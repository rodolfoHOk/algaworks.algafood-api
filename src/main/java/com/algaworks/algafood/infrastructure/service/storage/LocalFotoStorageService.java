package com.algaworks.algafood.infrastructure.service.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.algaworks.algafood.core.storage.StorageProperties;
import com.algaworks.algafood.domain.service.FotoStorageService;

@Service
public class LocalFotoStorageService implements FotoStorageService{
	
	@Autowired
	private StorageProperties storageProperties;
	
	@Override
	public FotoRecuperada recuperar(String nomeArquivo) {
		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);
			
			FotoRecuperada fotoRecuperada = FotoRecuperada.builder()
					.inputStream(Files.newInputStream(arquivoPath))
					.build();
		
			return fotoRecuperada;
		
		} catch (IOException e) {
			throw new StorageException("Não foi possível recuperar arquivo", e);
		}
	}

	@Override
	public void armazenar(NovaFoto novaFoto) {
		try {
			Path arquivoPath = getArquivoPath(novaFoto.getNomeArquivo());
		
			FileCopyUtils.copy(novaFoto.getInputStream(), Files.newOutputStream(arquivoPath));
		
		} catch (IOException e) {
			throw new StorageException("Não foi possível armazenar arquivo", e);
		}	
	}

	@Override
	public void remover(String nomeArquivo) {
		try {
			Path arquivoPath = getArquivoPath(nomeArquivo);
		
			Files.deleteIfExists(arquivoPath);
		
		} catch (IOException e) {
			throw new StorageException("Não foi possível excluir arquivo existente", e);
		}
		
	}
	
	private Path getArquivoPath(String nomeArquivo) {
		return storageProperties.getLocal().getDiretorioFotos().resolve(Path.of(nomeArquivo));
	}
	
}

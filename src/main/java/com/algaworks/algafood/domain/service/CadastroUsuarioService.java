package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.UsuarioNaoEncontradoException;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {
	
//	private static final String MSG_USUARIO_EM_USO = "Usuário com o código %d não pode ser removido, pois está em uso";

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void alterarSenha(Long usarioId, String senhaAtual, String novaSenha) {
		Usuario usuario = buscar(usarioId);
		
		if (usuario.senhaNaoCoincideCom(senhaAtual)) {
			throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
		}
		
		usuario.setSenha(novaSenha);
	}
	
//	@Transactional
//	public void excluir(Long usuarioId) {
//		try {
//			usuarioRepository.deleteById(usuarioId);
//			usuarioRepository.flush();
//		
//		} catch (EmptyResultDataAccessException e) {
//			throw new UsuarioNaoEncontradoException(usuarioId);
//		
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(String.format(MSG_USUARIO_EM_USO, usuarioId));
//		}
//	}
	
}

# Authorization code grant type

## Solicitar autorização:

http://localhost:8081/oauth/authorize?response_type=code&client_id=foodanalytics&state=abc&redirect_uri=http://aplicacao-cliente

## Retorno do authorization server:

http://aplicacao-cliente/?code=rPV1Ed&state=abc

## Insomnia 

Authorization code - Solicitar token


# Implicit grant type

## Solicitar autorização:

http://localhost:8081/oauth/authorize?response_type=token&client_id=webadmin&state=abc&redirect_uri=http://aplicacao-cliente

## Retorno do authorization server:

http://aplicacao-cliente/#access_token=0bd926da-8180-4046-ad74-f152154a4d51&token_type=bearer&state=abc&expires_in=43199&scope=read%20write


# Authorization code grant type com PKCE

## Solicitar autorização:

Code verifier: MIdkYmWB9XJ0PGwu-slthQQRCG7G-0aRzQ-kRbDmIxMqECa7Zla0ct1.flVcj8i0g67kDCwo_Nap5c9bV.uYs3GC4-IDsDWzCoIpyLVeWJKyel~VUOGP8QFdHjdDZjhP
Code challenge (plain): MIdkYmWB9XJ0PGwu-slthQQRCG7G-0aRzQ-kRbDmIxMqECa7Zla0ct1.flVcj8i0g67kDCwo_Nap5c9bV.uYs3GC4-IDsDWzCoIpyLVeWJKyel~VUOGP8QFdHjdDZjhP
Code challenge (sha256): base64url(sha256("MIdkYmWB9XJ0PGwu-slthQQRCG7G-0aRzQ-kRbDmIxMqECa7Zla0ct1.flVcj8i0g67kDCwo_Nap5c9bV.uYs3GC4-IDsDWzCoIpyLVeWJKyel~VUOGP8QFdHjdDZjhP")) =
= 9JRZ2YdjikyL4v9AjA1dMuIKu_dMbhWqtHA45Gue1bs

Plain:

http://localhost:8081/oauth/authorize?response_type=code&client_id=foodanalytics&redirect_uri=http://aplicacao-cliente
&code_challenge=MIdkYmWB9XJ0PGwu-slthQQRCG7G-0aRzQ-kRbDmIxMqECa7Zla0ct1.flVcj8i0g67kDCwo_Nap5c9bV.uYs3GC4-IDsDWzCoIpyLVeWJKyel~VUOGP8QFdHjdDZjhP
&code_challenge_method=plain

Sha256:

http://localhost:8081/oauth/authorize?response_type=code&client_id=foodanalytics&redirect_uri=http://aplicacao-cliente
&code_challenge=9JRZ2YdjikyL4v9AjA1dMuIKu_dMbhWqtHA45Gue1bs
&code_challenge_method=s256

## Retorno do authorization server:

Plain:

http://aplicacao-cliente/?code=EJBiaO

Sha256:

http://aplicacao-cliente/?code=GFmVHw

## Insomnia 

Authorization code com PKCE - Solicitar token


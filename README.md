# analizador-contrasenias
Analizador de contraseñas basado en su entropía escrito en Java.

La fórmula para calcular la entropía es el logaritmo en base 2 del conjunto de caracteres posibles multiplicado por la longitud de la cadena.

Se usará [la base de datos de las 10.000 contraseñas más comunes](https://github.com/danielmiessler/SecLists/blob/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt) proporcionada por el OWASP para el proyecto SecList.

Una vez analizada la contraseña se especifica qué aspectos la hacen débil y qué se puede hacer para mejorarla, además de sugerir una nueva contraseña con elementos aleatorios escogidos por el usuario.

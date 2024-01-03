# analizador-contras
Analizador de contraseñas basado en su entropía con un asistente virtual escrito en Java.

La fórmula para calcular la entropía es el logaritmo en base 2 del conjunto de caracteres posibles multiplicado por la longitud de la cadena.

Se usará [la base de datos de las 10.000 contraseñas más comunes](https://github.com/danielmiessler/SecLists/blob/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt) proporcionada por el OWASP para el proyecto SecList.

El asistente virtual debe dar sugerencias sobre cómo mejorar la seguridad de una contraseña, especificar qué elementos la hacen débil, modificar la contraseña con el consentimiento del usuario.

# analizador-contras
Analizador de contraseñas basado en su entropía con un asistente virtual escrito en Java.

La fórmula para calcular la entropía es el logaritmo en base 2 del conjunto de caracteres posibles multiplicado por la longitud de la cadena.

Se usará [la base de datos de las 10.000 contraseñas más comunes](https://github.com/danielmiessler/SecLists/blob/master/Passwords/Common-Credentials/10-million-password-list-top-10000.txt) proporcionada por el OWASP para el proyecto SecList.

El asistente virtual debe dar sugerencias sobre cómo mejorar la seguridad de una contraseña, especificar qué elementos la hacen débil, modificar la contraseña con el consentimiento del usuario o cualquier otra funcionalidad que una IA integraría en este analizador.

Por hacer
- Funcionalidad de diccionarios para analizar subcadenas con respecto a la lista de contraseñas comunes - HECHO
- Funcionalidad de detectar secuencias simples en subcadenas (secuencias de teclado como asdfg, iiiiii, 1234; fechas como 20020503, 2002-05-03) - HECHO
- Excepciones en caso el usuario ingrese una cadena vacía - POR HACER
  - Las clases Verificator, Suggestions_Password y Generate_New_Password faltan ser implementadas en el new Main.
- Programar el asistente virtual - POR HACER

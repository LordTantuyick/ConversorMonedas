# Conversor de Monedas

Este proyecto implementa un conversor de monedas en Java que utiliza la API de ExchangeRate-API para obtener los tipos de cambio actualizados.

## Autor
* Daniel Lorenzana Méndez

## Funcionalidades

* Convierte entre diferentes monedas (dólar, peso argentino, real brasileño, peso colombiano, peso mexicano).
* Obtiene los tipos de cambio actualizados desde la API de ExchangeRate-API.
* Guarda la información de las conversiones en archivos JSON con formato "pretty printing".
* Interfaz de línea de comandos (CLI) para interactuar con el usuario.

## Estructura del proyecto

El proyecto está organizado en las siguientes clases:

* `Moneda`: Representa una moneda con su nombre, símbolo y tipo de cambio.
* `TipoCambio`: Contiene un `Record` `Rates` para almacenar los tipos de cambio de las monedas.
* `ConversorMonedas`: Realiza las conversiones entre monedas y actualiza los tipos de cambio desde la API.
* `DatosConversion`: Contiene un `Record` `Conversion` para almacenar los datos de una conversión.
* `GestorJSON`: Guarda la información de las conversiones en archivos JSON.
* `Principal`: Clase principal que contiene el método `main` y la interfaz de línea de comandos.

## Uso

1.  Clona el repositorio: `git clone https://github.com/LordTantuyick/ConversorMonedas`
2.  Compila el código: `javac *.java`
3.  Ejecuta la aplicación: `java Principal`
4.  Introduce tu clave de API de ExchangeRate-API cuando se te solicite.
5.  Sigue las instrucciones en la interfaz de línea de comandos para realizar las conversiones.

## Dependencias

* Gson: Librería para procesar datos JSON. Asegúrate de tener Gson.jar en tu classpath.

## API Key

Para utilizar este proyecto, necesitas obtener una clave de API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/).

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.

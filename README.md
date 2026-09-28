# Conversor de Temperatura CLI

Programa em Java que lê uma temperatura em Celsius pelo terminal e converte
para Fahrenheit e Kelvin, tratando entradas inválidas (texto, valores vazios etc).

## Como funciona

- `celsiusParaFahrenheit`: aplica a fórmula `C * 9/5 + 32`.
- `celsiusParaKelvin`: aplica `C + 273.15` e valida que o resultado não fica
  abaixo do zero absoluto.
- `lerCelsius`: usa `Scanner` dentro de um `try/catch` com `InputMismatchException`
  para pedir a entrada de novo caso o usuário digite algo que não seja número.
- O `Scanner` usa `Locale.US`, então o separador decimal é sempre o ponto (`25.5`),
  mesmo em sistemas configurados em português.
- Se o valor estiver abaixo do zero absoluto (-273.15°C), o programa mostra a
  conversão para Fahrenheit e avisa que não dá para converter para Kelvin.

## Como executar

```bash
cd src
javac ConversorTemperatura.java
java ConversorTemperatura
```

Exemplo de execução:

```
Digite a temperatura em Celsius: abc
Entrada inválida. Digite um número (ex: 25.5).
Digite a temperatura em Celsius: 25
25.00°C equivale a 77.00°F
25.00°C equivale a 298.15K
```

Exemplo abaixo do zero absoluto:

```
Digite a temperatura em Celsius: -300
-300.00°C equivale a -508.00°F
Não foi possível converter para Kelvin: Temperatura abaixo do zero absoluto.
```

## Possíveis melhorias futuras
- Permitir escolher a unidade de entrada (não só Celsius).
- Testes unitários com JUnit para os métodos de conversão.

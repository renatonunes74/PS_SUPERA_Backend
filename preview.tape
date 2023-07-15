Set Theme { "black": "#0a0f14", "red": "#c33027", "green": "#26a98b", "yellow": "#edb54b", "blue": "#195465", "purple": "#4e5165", "cyan": "#33859d", "white": "#a9b1d6", "brightBlack": "#414868", "brightRed": "#f7768e", "brightGreen": "#a6e3a1", "brightYellow": "#e0af68", "brightBlue": "#7aa2f7", "brightPurple": "#bb9af7", "brightCyan": "#7dcfff", "brightWhite": "#c0caf5", "background": "#0a0f14", "foreground": "#98d1ce", "selectionBackground": "#093748", "cursorColor": "#98d1ce" }
Output preview.gif
Set FontSize 16
Set Framerate 60
Set Height 600
Set Padding 20
Set Shell zsh
Set TypingSpeed 0.2
Type "http http://localhost:8080/transferencias; : Listar todas as transferências" Sleep 2s Enter Sleep 3s
Type "http http://localhost:8080/transferencias/conta/1; : Listar todas as transferências por conta" Sleep 2s Enter Sleep 3s
Type "http http://localhost:8080/transferencias/operador/beltrano; : Listar todas as transferências por nome do operador de transação" Sleep 2s Enter Sleep 3s
Type "http 'localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01'; : Listar todas as transferências por período de tempo" Sleep 2s Enter Sleep 3s
Type "http 'localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01&conta=1'; : Listar todas as transferências por período de tempo e conta" Sleep 2s Enter Sleep 3s
Type "http 'localhost:8080/transferencias/filtro?inicio=2017-01-01&fim=2022-01-01&conta=1&operador=beltrano'; : Listar todas as transferências por período de tempo, conta e nome do operador de transação" Sleep 2s Enter Sleep 7s

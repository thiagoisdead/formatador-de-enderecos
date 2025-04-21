Formatador de endereços

## Casos de teste 

### Casos simples:

- **Entradas:** 
  - “Miritiba 339” - “Babaçu 500” - “Cambuí 804B”
  
- **Ação que faz:** Separa nomes e números, que são separados por espaços simples.

- **Saída:**
  
  - ‘Rua: Miritiba, Número: 339’
  - ‘Rua: Babaçu, Número: 500’
  - ‘Rua: Cambuí, Número: 804B’

### Casos mais complicados:

- **Entrada:** 
  - “Rio Branco 23” - “Quirino dos Santos 23 b” 
- **Ação que faz:** Separa nomes e números, separados por diversos espaços.
  
- **Saída:**
- 
  - ‘Rua: Rio Branco, Número: 23’
  - ‘Rua: Quirino dos Santos, Número: 23 b’

### Casos Complexos:

- **Entrada:** 
  - “4, Rue de la République” - “100 Broadway Av” - “Calle Sagasta, 26” - “Calle 44 No 1991”
    
- **Ação que faz:** Separa nomes e números, separados por espaços, vírgulas e se encontram em diferentes ordens. Contém endereços de outros Paises
  
- **Saída:**
  
  - ‘Rua: Rue de la République, Número: 4’
  - ‘Rua: Broadway Av, Número: 100’
  - ‘Rua: Calle Sagasta, Número: 26’
  - ‘Rua: Calle 44, Número: No 1991’

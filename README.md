# AP2ProjetoFinal
Um sistema simples de mercado juntamente com um PDV. Usando integrações com SQL e saída de dados usando planilhas em excel

Estrutura e linha de raciocínio do trabalho

Nome: Alysson e Maurício 

-- Mercado (Clientes, Produtos)
-- Estudar implementação de preço (venda/custo)
-- Estoque (Arraylist de produtos)
-- PDV (Arraylist de produtos) 
-- Cadastro de produto
-- Cadastro de cliente
-- Lançamento de nota (Excel)

Usuario
id INT PK
usuario STRING
senha STRING
admin Boolean 

/* Se der tempo
Fornecedor
id INT PK
CNPJ INT
Nome STRING
Email STRING
Telefone STRING
Endereco STRING */

Produto
id INT PK
Descrição STRING
ValorFinal DECIMAL
ValorUltimaCompra DECIMAL
Estoque INT


Transacao
id INT PK
Produtos INT FK
ValorTotal Decimal
Forma de pagamento (ENUM: DINHEIRO, CARTAO (credito, debito, vale))
Status Boolean

Nota
id INT PK
Numero Transação INT FK
Tipo (ENUM: 'S')


Usar excel <- (Notas) e sql <- (Para o resto)
Ter um arquivo texto para log de erros <- Obrigatório

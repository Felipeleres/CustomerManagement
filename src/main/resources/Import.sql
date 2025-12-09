INSERT INTO tb_cliente (name, cpf) VALUES ('Felipe Leres', '12345678900');
INSERT INTO tb_cliente (name, cpf) VALUES ('Maria Silva', '98765432100');

INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data, valor, forma_pagamento) VALUES ('PROC-001', 1, 'Abertura de processo de consultoria', 0, '2025-01-10', 5000.00, 0);
INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data, valor, forma_pagamento) VALUES ('PROC-002', 1, 'Processo trabalhista', 1, '2025-02-15', 3000.00, 1);
INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data, valor, forma_pagamento) VALUES ('PROC-003', 2, 'Assessoria jurídica', 0, '2025-03-05', 8000.00, 1);

INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_parcela) VALUES (0, 1, 1, 5000.00);
INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_parcela) VALUES(2, 2, 3, 1000.00);
INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_parcela) VALUES(1, 3, 4, 2000.00);

INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(1000.00, '2025-03-10', 0, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(1000.00, '2025-04-10', 2, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(1000.00, '2025-05-10', 2, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(2000.00, '2025-02-01', 1, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(2000.00, '2025-03-01', 1, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(2000.00, '2025-04-01', 2, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(2000.00, '2025-05-01', 2, 3);

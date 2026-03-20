INSERT INTO tb_cliente (name, cpf,email,telefone) VALUES ('Felipe Leres', '12345678900','felipe@gmail.com','19999999999');
INSERT INTO tb_cliente (name, cpf,email,telefone) VALUES ('Maria Silva', '98765432100','maria@gmail.com','19999999999');


INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data) VALUES ('PROC-001', 1, 'Abertura de processo de consultoria', 'aguardando juiz', '2025-01-10');
INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data) VALUES ('PROC-002', 1, 'Processo trabalhista', 'contactar cliente', '2025-02-15');
INSERT INTO tb_processo (numero, cliente_id, descricao, situacao, data) VALUES ('PROC-003', 2, 'Assessoria jurídica', 'aguardando audiencia', '2025-03-05');

INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_total) VALUES (0, 1, 1, 5000.00);
INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_total) VALUES(2, 2, 3, 1000.00);
INSERT INTO tb_pagamento (status_pagamento, processo_id, quantidade_parcelas, valor_total) VALUES(1, 3, 4, 2000.00);

INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(5000.00, '2025-03-10', 0, 1);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(100.00, '2025-04-10', 0, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(800.00, '2026-05-10', 2, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(100.00, '2025-02-01', 1, 2);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(500.00, '2025-03-01', 0, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(500.00, '2025-04-01', 0, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(500.00, '2025-05-01', 0, 3);
INSERT INTO tb_parcela (valor, data_parcela, status_pagamento, pagamento_id) VALUES(500.00, '2025-03-01', 0, 3);

INSERT INTO tb_user (name, cpf,email,telefone,password) VALUES ('karol bender', '987654345450','karol@gmail.com','19999999999','$2a$10$5arbi/81htwyJbbxtP/ryexCo2wfsc.A3qP5yQW/hiE0w3lb/1FvW');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);


INSERT INTO payments
    (id, customer_id, amount, currency, status, created_at)
VALUES
    (1, 'CUST-1', 100.50, 'USD', 'SUCCESS', TIMESTAMP '2026-10-07 17:30:00');

INSERT INTO payments
    (id, customer_id, amount, currency, status, created_at)
VALUES
    (2, 'CUST-2', 250.75, 'USD', 'PENDING', CURRENT_TIMESTAMP);
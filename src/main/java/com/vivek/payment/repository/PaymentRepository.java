package com.vivek.payment.repository;

import com.vivek.payment.entity.Payment;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Payment> findById(Long id){
        String sql = """
                SELECT id, customer_id, amount, currency, status, created_at
                FROM payments
                WHERE id = ?
                """;

        RowMapper<Payment> rowMapper = (rs, rowNum) -> {
            return new Payment(
                    // map columns here
                    rs.getLong("id"),
                    rs.getString("customer_id"),
                    rs.getBigDecimal("amount"),
                    rs.getString("currency"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            );
        };

        List<Payment> payments = jdbcTemplate.query(sql, rowMapper, id);

        return payments.stream().findFirst();

    }
}

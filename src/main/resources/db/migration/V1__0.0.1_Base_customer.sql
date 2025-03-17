
CREATE TABLE IF NOT EXISTS customer
(
    customer_id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                      CHARACTER VARYING NOT NULL,
    tax_identification_number CHARACTER VARYING,
    tax_identification_type   CHARACTER VARYING,
    tax_regime                CHARACTER VARYING,
    annual_revenue            NUMERIC(14, 2),
    country                   CHARACTER VARYING,
    address                   CHARACTER VARYING,
    postal_code               CHARACTER VARYING,
    business_sector           CHARACTER VARYING,
    establishment_date        DATE,
    notes                     TEXT,
    currency_id               UUID,
    company_id                UUID NOT NULL
    );

CREATE INDEX IF NOT EXISTS customer_name_idx ON customer (name);
CREATE INDEX IF NOT EXISTS customer_tax_identification_number_idx ON customer (tax_identification_number);

CREATE TABLE IF NOT EXISTS contact
(
    contact_id                      UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                            CHARACTER VARYING,
    email                           CHARACTER VARYING,
    phone                           CHARACTER VARYING,
    preferred_communication_channel CHARACTER VARYING,
    preferred_language              CHARACTER VARYING,
    role                            CHARACTER VARYING,
    company_id                      UUID NOT NULL
    );

CREATE INDEX IF NOT EXISTS contact_name_idx ON contact (name);

CREATE TABLE IF NOT EXISTS customer_contact
(
    customer_id UUID NOT NULL,
    contact_id  UUID NOT NULL,
    PRIMARY KEY (customer_id, contact_id),
    CONSTRAINT fk_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (customer_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_contact
    FOREIGN KEY (contact_id)
    REFERENCES contact (contact_id)
    ON DELETE CASCADE
    );

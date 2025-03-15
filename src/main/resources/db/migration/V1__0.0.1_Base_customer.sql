CREATE TABLE IF NOT EXISTS currency
(
    currency_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        CHARACTER VARYING,
    symbol      CHARACTER VARYING(3),
    code        CHARACTER VARYING(3)
    );

CREATE TABLE IF NOT EXISTS company
(
    company_id  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        CHARACTER VARYING NOT NULL,
    country     CHARACTER VARYING,
    currency_id UUID,
    CONSTRAINT company_currency_fk FOREIGN KEY (currency_id) REFERENCES currency (currency_id)
    );

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
    company_id                UUID NOT NULL,
    CONSTRAINT company_fk FOREIGN KEY (company_id) REFERENCES company (company_id),
    CONSTRAINT customer_currency_fk FOREIGN KEY (currency_id) REFERENCES currency (currency_id)
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
    company_id                      UUID NOT NULL,
    CONSTRAINT company_fk FOREIGN KEY (company_id) REFERENCES company (company_id)
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


INSERT INTO currency (name, symbol, code)
VALUES ('US Dollar', '$', 'USD');
INSERT INTO currency (name, symbol, code)
VALUES ('Euro', '€', 'EUR');
INSERT INTO currency (name, symbol, code)
VALUES ('Japanese Yen', '¥', 'JPY');
INSERT INTO currency (name, symbol, code)
VALUES ('British Pound', '£', 'GBP');
INSERT INTO currency (name, symbol, code)
VALUES ('Australian Dollar', 'A$', 'AUD');
INSERT INTO currency (name, symbol, code)
VALUES ('Canadian Dollar', 'C$', 'CAD');
INSERT INTO currency (name, symbol, code)
VALUES ('Swiss Franc', 'CHF', 'CHF');
INSERT INTO currency (name, symbol, code)
VALUES ('Chinese Yuan', '¥', 'CNY');
INSERT INTO currency (name, symbol, code)
VALUES ('Hong Kong Dollar', 'HK$', 'HKD');
INSERT INTO currency (name, symbol, code)
VALUES ('New Zealand Dollar', 'NZ$', 'NZD');
INSERT INTO currency (name, symbol, code)
VALUES ('Swedish Krona', 'kr', 'SEK');
INSERT INTO currency (name, symbol, code)
VALUES ('Norwegian Krone', 'kr', 'NOK');
INSERT INTO currency (name, symbol, code)
VALUES ('Russian Ruble', '₽', 'RUB');
INSERT INTO currency (name, symbol, code)
VALUES ('Indian Rupee', '₹', 'INR');
INSERT INTO currency (name, symbol, code)
VALUES ('Brazilian Real', 'R$', 'BRL');
INSERT INTO currency (name, symbol, code)
VALUES ('South African Rand', 'R', 'ZAR');
INSERT INTO currency (name, symbol, code)
VALUES ('Mexican Peso', '$', 'MXN');
INSERT INTO currency (name, symbol, code)
VALUES ('Singapore Dollar', 'S$', 'SGD');
INSERT INTO currency (name, symbol, code)
VALUES ('South Korean Won', '₩', 'KRW');
INSERT INTO currency (name, symbol, code)
VALUES ('Turkish Lira', '₺', 'TRY');
INSERT INTO currency (name, symbol, code)
VALUES ('Israeli New Shekel', '₪', 'ILS');
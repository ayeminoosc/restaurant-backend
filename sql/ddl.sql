DROP TABLE IF EXISTS organization CASCADE;
CREATE TABLE organization (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    name VARCHAR(255) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS restaurant CASCADE;
CREATE TABLE restaurant (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    organization_id VARCHAR(255) NOT NULL REFERENCES organization(id),
    unique_id INTEGER,
    name VARCHAR(255),
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    address_line3 VARCHAR(255),
    zip_code VARCHAR(255),
    telephone VARCHAR(255),
    capacity INTEGER,
    tables INTEGER,
    cname VARCHAR(255),
    csymbol VARCHAR(255),
    sc_percentage DOUBLE PRECISION,
    gratuity_percentage DOUBLE PRECISION,
    ticket_footer VARCHAR(255),
    price_includes_tax BOOLEAN,
    allow_modifier_max_exceed BOOLEAN
);

DROP TABLE IF EXISTS subscription CASCADE;
CREATE TABLE subscription (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    organization_id VARCHAR(255) NOT NULL REFERENCES organization(id),
    plan_name VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    trial_end_date TIMESTAMP
);

DROP TABLE IF EXISTS user_type CASCADE;
CREATE TABLE user_type (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) REFERENCES restaurant(id),
    p_name VARCHAR(60)
);

DROP TABLE IF EXISTS shift CASCADE;
CREATE TABLE shift (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) REFERENCES restaurant(id),
    name VARCHAR(60) UNIQUE,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    shift_len BIGINT
);


DROP TABLE IF EXISTS terminal CASCADE;
CREATE TABLE terminal (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) REFERENCES restaurant(id),
    name VARCHAR(60),
    terminal_key VARCHAR(120),
    opening_balance DOUBLE PRECISION,
    current_balance DOUBLE PRECISION,
    has_cash_drawer BOOLEAN,
    in_use BOOLEAN,
    active BOOLEAN,
    location VARCHAR(320),
    floor_id INTEGER,
    assigned_user VARCHAR(255)
);

DROP TABLE IF EXISTS user CASCADE;
CREATE TABLE user (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    organization_id VARCHAR(255) NOT NULL REFERENCES organization(id),
    restaurant_id VARCHAR(255) REFERENCES restaurant(id),
    is_owner BOOLEAN DEFAULT false,
    user_pass VARCHAR(255) NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    ssn VARCHAR(30),
    cost_per_hour DOUBLE PRECISION,
    clocked_in BOOLEAN,
    last_clock_in_time TIMESTAMP,
    last_clock_out_time TIMESTAMP,
    phone_no VARCHAR(20),
    email VARCHAR(40) unique,
    active BOOLEAN,
    shift_id VARCHAR(255) REFERENCES shift(id),
    current_terminal VARCHAR(255) REFERENCES terminal(id),
    n_user_type VARCHAR(255) REFERENCES user_type(id)
);
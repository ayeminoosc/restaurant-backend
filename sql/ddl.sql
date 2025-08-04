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
    unique_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    address_line3 VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(255),
    country VARCHAR(255),
    telephone VARCHAR(255),
    email VARCHAR(255),
    website VARCHAR(500),
    capacity INTEGER,

    currency_name VARCHAR(255),
    currency_symbol VARCHAR(10),
    currency_code VARCHAR(3),
    service_charge_percentage DOUBLE PRECISION,
    gratuity_percentage DOUBLE PRECISION,
    tax_percentage DOUBLE PRECISION,
    ticket_footer VARCHAR(500),
    price_includes_tax BOOLEAN DEFAULT false,
    allow_modifier_max_exceed BOOLEAN DEFAULT false,
    is_active BOOLEAN DEFAULT true,
    timezone VARCHAR(50),
    opening_time VARCHAR(10),
    closing_time VARCHAR(10),
    logo_url VARCHAR(500),
    cuisine_type VARCHAR(100),
    delivery_enabled BOOLEAN DEFAULT false,
    takeout_enabled BOOLEAN DEFAULT true,
    reservation_enabled BOOLEAN DEFAULT false
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

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) NOT NULL REFERENCES restaurant(id),
    parent_category_id VARCHAR(255) REFERENCES category(id),
    name VARCHAR(255) NOT NULL,
    bilingual_name VARCHAR(255),
    description TEXT,
    display_order INTEGER,
    is_active BOOLEAN DEFAULT true,
    color_code VARCHAR(7),
    icon_url VARCHAR(500),
    tax_applicable BOOLEAN DEFAULT true
);

DROP TABLE IF EXISTS floor_plan CASCADE;
CREATE TABLE floor_plan (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) NOT NULL REFERENCES restaurant(id),
    name VARCHAR(255) NOT NULL,
    description TEXT,
    width_pixels INTEGER,
    height_pixels INTEGER,
    background_color VARCHAR(7),
    background_image_url VARCHAR(500),
    grid_size INTEGER DEFAULT 20,
    is_active BOOLEAN DEFAULT true,
    is_default BOOLEAN DEFAULT false,
    display_order INTEGER
);

DROP TABLE IF EXISTS restaurant_table CASCADE;
CREATE TABLE restaurant_table (
    id VARCHAR(255) PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    last_sync_time TIMESTAMP,
    is_dirty BOOLEAN DEFAULT false,
    deleted BOOLEAN DEFAULT false,
    restaurant_id VARCHAR(255) NOT NULL REFERENCES restaurant(id),
    floor_plan_id VARCHAR(255) NOT NULL REFERENCES floor_plan(id),
    table_number VARCHAR(50) NOT NULL,
    table_name VARCHAR(255),
    table_style VARCHAR(50) NOT NULL,
    x_position INTEGER NOT NULL,
    y_position INTEGER NOT NULL,
    width_pixels INTEGER,
    height_pixels INTEGER,
    rotation_degrees INTEGER DEFAULT 0,
    capacity INTEGER,
    min_capacity INTEGER,
    max_capacity INTEGER,
    is_active BOOLEAN DEFAULT true,
    is_reservable BOOLEAN DEFAULT true,
    color_code VARCHAR(7),
    notes TEXT,
    section_name VARCHAR(255),
    server_station VARCHAR(255),
    UNIQUE(restaurant_id, table_number)
);
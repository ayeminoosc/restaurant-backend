CREATE TABLE refresh_token (
    id UUID PRIMARY KEY,                   -- token value
    user_id VARCHAR(255) NOT NULL,         -- links to User
    device_name TEXT,                      -- e.g., “Cashier Tablet A”, “iPad Kitchen”
    ip_address TEXT,                       -- IP of login device
    user_agent TEXT,                       -- e.g., mobile app version
    created_at TIMESTAMP DEFAULT now(),    -- issued time
    expires_at TIMESTAMP NOT NULL,         -- absolute expiry
    revoked BOOLEAN DEFAULT false,         -- status flag
    last_used_at TIMESTAMP,                -- optional: track token usage
    location TEXT                          -- optional: city/country (if using IP-based geo)
);

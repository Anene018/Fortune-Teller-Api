CREATE TABLE signs (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  image_url VARCHAR(255) NOT NULL
);

CREATE TABLE horoscopes (
  id SERIAL PRIMARY KEY,
  sign_id INTEGER NOT NULL REFERENCES signs(id),
  timeframe VARCHAR(10) NOT NULL CHECK (timeframe IN ('daily', 'weekly', 'monthly')),
  reading TEXT NOT NULL
);

-- Create aromas table
CREATE TABLE IF NOT EXISTS aromas (
    aroma_id UUID PRIMARY KEY,
    aroma_name VARCHAR(255) NOT NULL
);

-- Create rating_details table
CREATE TABLE IF NOT EXISTS rating_details (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    rating DOUBLE PRECISION,
    votes INTEGER,
    numberOf1Stars INTEGER,
    numberOf2Stars INTEGER,
    numberOf3Stars INTEGER,
    numberOf4Stars INTEGER,
    numberOf5Stars INTEGER,
    median INTEGER,
    mode INTEGER
);

-- Create rating table
CREATE TABLE IF NOT EXISTS rating (
    rating_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),    
    rating_overall UUID,
    rating_aroma UUID,
    rating_taste UUID,
    rating_aftertaste UUID,
    rating_balance UUID,
    rating_complexity UUID,
    rating_smoothness UUID,
    rating_valueForMoney UUID,
    FOREIGN KEY (rating_overall) REFERENCES rating_details (id),
    FOREIGN KEY (rating_aroma) REFERENCES rating_details (id),
    FOREIGN KEY (rating_taste) REFERENCES rating_details (id),
    FOREIGN KEY (rating_aftertaste) REFERENCES rating_details (id),
    FOREIGN KEY (rating_balance) REFERENCES rating_details (id),
    FOREIGN KEY (rating_complexity) REFERENCES rating_details (id),
    FOREIGN KEY (rating_smoothness) REFERENCES rating_details (id),
    FOREIGN KEY (rating_valueForMoney) REFERENCES rating_details (id)
);

-- Create rum_list table
CREATE TABLE IF NOT EXISTS rum_list (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    country VARCHAR(255),
    destillery VARCHAR(255),
    destilation VARCHAR(255),  
    bottled_country VARCHAR(255),
    type VARCHAR(255),
    aging_style VARCHAR(255),
    style VARCHAR(255),
    color VARCHAR(255),
    barrel_type VARCHAR(255),
    brand VARCHAR(255),
    alcohol_content VARCHAR(255),
    volume VARCHAR(255),
    price VARCHAR(255),
    currency VARCHAR(50),  
    image VARCHAR(255),
    size VARCHAR(255),
    aromas TEXT[],
    rating UUID
);

-- Create rum_list_aromas table
CREATE TABLE IF NOT EXISTS rum_list_aromas (
    rum_detail_id UUID NOT NULL,
    aroma_id UUID NOT NULL,
    PRIMARY KEY (rum_detail_id, aroma_id),
    FOREIGN KEY (rum_detail_id) REFERENCES rum_list(id),
    FOREIGN KEY (aroma_id) REFERENCES aromas(aroma_id)
);

-- Create rum_list_rating table
CREATE TABLE IF NOT EXISTS rum_list_rating (
    rum_detail_id UUID NOT NULL,
    rating_id UUID NOT NULL,
    PRIMARY KEY (rum_detail_id, rating_id),
    FOREIGN KEY (rum_detail_id) REFERENCES rum_list(id),
    FOREIGN KEY (rating_id) REFERENCES rating(rating_id)
);

CREATE TABLE IF NOT EXIST brands(
    
)
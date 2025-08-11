-- Insert into category table
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Produits alimentaires traditionnels du Maroc', 'Épicerie'),
    (nextval('category_seq'), 'Appareils électroniques et électroménagers', 'Électronique'),
    (nextval('category_seq'), 'Produits artisanaux marocains', 'Artisanat'),
    (nextval('category_seq'), 'Produits de beauté et soins', 'Cosmétiques');

-- Insert into product table
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Huile d’argan pure extraite à Agadir', 'Huile d’argan', 100, 120.00,  currval('category_seq') - 1), -- Cosmétiques
    (nextval('product_seq'), 'Tajine en terre cuite fait main', 'Tajine marocain', 50, 150.00,  currval('category_seq') - 2), -- Artisanat
    (nextval('product_seq'), 'Safran pur de Taliouine', 'Safran', 20, 250.00,  currval('category_seq') - 3), -- Épicerie
    (nextval('product_seq'), 'Téléviseur LED 42 pouces', 'TV LED', 15, 3000.00, currval('category_seq') - 4), -- Électronique
    (nextval('product_seq'), 'Beldi savon noir à l’eucalyptus', 'Savon noir', 200, 30.00, currval('category_seq') - 1); -- Cosmétiques

-- Épicerie
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Miel de fleurs d’oranger pur', 'Miel d’oranger', 80, 90.00, 1),
    (nextval('product_seq'), 'Amlou (pâte à tartiner berbère) à base d’amandes, miel et huile d’argan', 'Amlou', 60, 180.00, 1),
    (nextval('product_seq'), 'Dattes Majhoul de la vallée du Drâa', 'Dattes Majhoul', 120, 150.00, 1),
    (nextval('product_seq'), 'Olives noires marinées aux herbes', 'Olives noires', 200, 35.00, 1),
    (nextval('product_seq'), 'Couscous complet aux 7 céréales', 'Couscous complet', 90, 50.00, 1);

-- Électronique
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone Android dernière génération', 'Smartphone Atlas X1', 25, 3200.00, 2),
    (nextval('product_seq'), 'Climatiseur mural 12000 BTU', 'Climatiseur SaharaCool', 10, 4200.00, 2),
    (nextval('product_seq'), 'Cafetière électrique 12 tasses', 'Cafetière Baraka', 40, 450.00, 2),
    (nextval('product_seq'), 'Ordinateur portable 15 pouces', 'Laptop RifBook', 18, 7200.00, 2),
    (nextval('product_seq'), 'Réfrigérateur double porte', 'Frigo AtlasFresh', 8, 5800.00, 2);

-- Artisanat
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Tapis berbère tissé à la main', 'Tapis berbère', 12, 2500.00, 3),
    (nextval('product_seq'), 'Plateau en cuivre gravé', 'Plateau gravé', 20, 700.00, 3),
    (nextval('product_seq'), 'Babouches en cuir de Fès', 'Babouches marocaines', 50, 150.00, 3),
    (nextval('product_seq'), 'Poterie décorative de Safi', 'Vase Safi', 30, 300.00, 3),
    (nextval('product_seq'), 'Lampe artisanale en métal ajouré', 'Lampe orientale', 15, 450.00, 3);

-- Cosmétiques
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Crème hydratante à base d’huile d’argan', 'Crème à l’argan', 70, 120.00, 4),
    (nextval('product_seq'), 'Eau de rose pure de Kelaat M’Gouna', 'Eau de rose', 100, 60.00, 4),
    (nextval('product_seq'), 'Shampoing naturel au romarin', 'Shampoing romarin', 85, 75.00, 4),
    (nextval('product_seq'), 'Gommage corporel au sucre et huile d’olive', 'Gommage beldi', 60, 95.00, 4),
    (nextval('product_seq'), 'Huile essentielle de menthe poivrée', 'Huile de menthe', 50, 80.00, 4);

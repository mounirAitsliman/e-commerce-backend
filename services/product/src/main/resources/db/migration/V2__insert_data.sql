-- CATEGORIES
INSERT INTO category (id, description, name) VALUES
  (nextval('category_seq'), 'Produits alimentaires traditionnels du Maroc', 'Épicerie'),
  (nextval('category_seq'), 'Appareils électroniques et électroménagers', 'Électronique'),
  (nextval('category_seq'), 'Produits artisanaux marocains', 'Artisanat'),
  (nextval('category_seq'), 'Produits de beauté et soins', 'Cosmétiques');

-- PRODUITS (référence par name -> id)
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES
  (nextval('product_seq'), 'Huile d''argan pure extraite à Agadir', 'Huile d''argan', 100, 120.00,
      (SELECT id FROM category WHERE name = 'Cosmétiques')),
  (nextval('product_seq'), 'Tajine en terre cuite fait main', 'Tajine marocain', 50, 150.00,
      (SELECT id FROM category WHERE name = 'Artisanat')),
  (nextval('product_seq'), 'Safran pur de Taliouine', 'Safran', 20, 250.00,
      (SELECT id FROM category WHERE name = 'Épicerie')),
  (nextval('product_seq'), 'Téléviseur LED 42 pouces', 'TV LED', 15, 3000.00,
      (SELECT id FROM category WHERE name = 'Électronique')),
  (nextval('product_seq'), 'Beldi savon noir à l’eucalyptus', 'Savon noir', 200, 30.00,
      (SELECT id FROM category WHERE name = 'Cosmétiques'));

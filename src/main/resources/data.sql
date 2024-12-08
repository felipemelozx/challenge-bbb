INSERT INTO Candidato (id, name)
SELECT 1, 'João Silva'
WHERE NOT EXISTS (
    SELECT 1 FROM Candidato WHERE id = 1
);

INSERT INTO Candidato (id, name)
SELECT 2, 'Maria Oliveira'
WHERE NOT EXISTS (
    SELECT 1 FROM Candidato WHERE id = 2
);

INSERT INTO Candidato (id, name)
SELECT 3, 'Carlos Souza'
WHERE NOT EXISTS (
    SELECT 1 FROM Candidato WHERE id = 3
);

INSERT INTO Candidato (id, name)
SELECT 4, 'Ana Pereira'
WHERE NOT EXISTS (
    SELECT 1 FROM Candidato WHERE id = 4
);

INSERT INTO Candidato (id, name)
SELECT 5, 'Pedro Santos'
WHERE NOT EXISTS (
    SELECT 1 FROM Candidato WHERE id = 5
);
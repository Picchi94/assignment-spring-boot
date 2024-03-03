CREATE TABLE IF NOT EXISTS csv_model (
    source VARCHAR(255),
    codeListCode VARCHAR(255),
    code VARCHAR(255),
    displayValue VARCHAR(255),
    longDescription VARCHAR(255),
    fromDate DATE,
    toDate DATE,
    sortingPriority INTEGER
);

-- Insert sample data
INSERT INTO csv_model (source, codeListCode, code, displayValue, longDescription, fromDate, toDate, sortingPriority) VALUES
('1', 'Item 1', 'code 1', 'displayCode1', 'longDescription1', now(), now(), 1);
--('2', 'Item 2', 'code 2', 'displayCode2', 'longDescription2', now(), now(), 1),
--('3', 'Item 3', 'code 3', 'displayCode3', 'longDescription3', now(), now(), 1),
--('4', 'Item 4', 'code 4', 'displayCode4', 'longDescription4', now(), now(), 1),
--('5', 'Item 5', 'code 5', 'displayCode5', 'longDescription5', now(), now(), 1),
--('6', 'Item 6', 'code 6', 'displayCode6', 'longDescription6', now(), now(), 1),
--('7', 'Item 7', 'code 7', 'displayCode7', 'longDescription7', now(), now(), 1)

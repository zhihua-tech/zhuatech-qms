-- Copyright 2026 上海如静知华信息科技有限公司
CREATE TABLE sys_user (id BIGINT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(40) NOT NULL UNIQUE,password VARCHAR(100) NOT NULL,display_name VARCHAR(40) NOT NULL,role VARCHAR(20) NOT NULL,enabled BOOLEAN NOT NULL,created_at DATETIME NOT NULL,updated_at DATETIME NOT NULL);
CREATE TABLE qms_inspection_lot (id BIGINT PRIMARY KEY AUTO_INCREMENT,lot_no VARCHAR(32) NOT NULL UNIQUE,material_code VARCHAR(32) NOT NULL,material_name VARCHAR(80) NOT NULL,source_type VARCHAR(24) NOT NULL,source_ref VARCHAR(40) NOT NULL,supplier_name VARCHAR(80),batch_qty INT NOT NULL,sample_qty INT NOT NULL,planned_date DATE NOT NULL,inspector VARCHAR(40),status VARCHAR(24) NOT NULL,result VARCHAR(24),defect_qty INT NOT NULL,remarks VARCHAR(300),created_at DATETIME NOT NULL,updated_at DATETIME NOT NULL);
CREATE TABLE qms_nonconformance (id BIGINT PRIMARY KEY AUTO_INCREMENT,nc_no VARCHAR(32) NOT NULL UNIQUE,lot_no VARCHAR(32) NOT NULL,defect_type VARCHAR(40) NOT NULL,severity VARCHAR(16) NOT NULL,description VARCHAR(300) NOT NULL,quantity INT NOT NULL,owner VARCHAR(40) NOT NULL,status VARCHAR(24) NOT NULL,due_date DATE NOT NULL,created_at DATETIME NOT NULL,updated_at DATETIME NOT NULL);
CREATE TABLE qms_capa_action (id BIGINT PRIMARY KEY AUTO_INCREMENT,action_no VARCHAR(32) NOT NULL UNIQUE,nc_no VARCHAR(32) NOT NULL,title VARCHAR(120) NOT NULL,owner VARCHAR(40) NOT NULL,due_date DATE NOT NULL,progress INT NOT NULL,status VARCHAR(24) NOT NULL,created_at DATETIME NOT NULL,updated_at DATETIME NOT NULL);
CREATE INDEX idx_qms_lot_date ON qms_inspection_lot(planned_date);
CREATE INDEX idx_qms_lot_status ON qms_inspection_lot(status);
CREATE INDEX idx_qms_nc_status ON qms_nonconformance(status);
CREATE INDEX idx_qms_capa_due ON qms_capa_action(due_date);

package com.github.ferstl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTableA is a Querydsl query type for QTableA
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTableA extends com.querydsl.sql.RelationalPathBase<QTableA> {

    private static final long serialVersionUID = 1157874796;

    public static final QTableA tableA = new QTableA("TABLE_A");

    public final StringPath description = createString("description");

    public final NumberPath<Short> id = createNumber("id", Short.class);

    public QTableA(String variable) {
        super(QTableA.class, forVariable(variable), "PUBLIC", "TABLE_A");
        addMetadata();
    }

    public QTableA(String variable, String schema, String table) {
        super(QTableA.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTableA(String variable, String schema) {
        super(QTableA.class, forVariable(variable), schema, "TABLE_A");
        addMetadata();
    }

    public QTableA(Path<? extends QTableA> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "TABLE_A");
        addMetadata();
    }

    public QTableA(PathMetadata metadata) {
        super(QTableA.class, metadata, "PUBLIC", "TABLE_A");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(2).ofType(Types.VARCHAR).withSize(50));
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.DECIMAL).withSize(4));
    }

}


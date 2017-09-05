package com.github.ferstl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTableB is a Querydsl query type for QTableB
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTableB extends com.querydsl.sql.RelationalPathBase<QTableB> {

    private static final long serialVersionUID = 1157874797;

    public static final QTableB tableB = new QTableB("TABLE_B");

    public final NumberPath<Short> aRef = createNumber("aRef", Short.class);

    public final StringPath category = createString("category");

    public QTableB(String variable) {
        super(QTableB.class, forVariable(variable), "PUBLIC", "TABLE_B");
        addMetadata();
    }

    public QTableB(String variable, String schema, String table) {
        super(QTableB.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTableB(String variable, String schema) {
        super(QTableB.class, forVariable(variable), schema, "TABLE_B");
        addMetadata();
    }

    public QTableB(Path<? extends QTableB> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "TABLE_B");
        addMetadata();
    }

    public QTableB(PathMetadata metadata) {
        super(QTableB.class, metadata, "PUBLIC", "TABLE_B");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(aRef, ColumnMetadata.named("A_REF").withIndex(1).ofType(Types.DECIMAL).withSize(4));
        addMetadata(category, ColumnMetadata.named("CATEGORY").withIndex(2).ofType(Types.VARCHAR).withSize(50));
    }

}


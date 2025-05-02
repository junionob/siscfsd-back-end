package org.fab.sisrecruta.projections.enums;

public enum TipoFuncao {
    CHEFE("CHEFE"),
    VICE_CHEFE("VICE CHEFE"),
    ENCARREGADO("ENCARREGADO"),
    INSTRUTOR("INSTRUTOR"),
    SUPERVISOR("SUPERVISOR"),
    MONITOR("MONITOR");

    private String descricao;

    TipoFuncao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

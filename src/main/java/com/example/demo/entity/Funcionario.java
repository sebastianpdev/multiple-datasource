package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "FUNCIONARIO", schema = "auditoria")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", schema = "auditoria", allocationSize = 1)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contratista_id")
    private int contratistaId;

    /*  FK  */
    @Column(name = "area_responsabilidad")
    private int areaResponsabilidad;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "firma")
    private String firma;

    /*  FK  */
    @Column(name = "padre_id")
    private int padreId;

    @Column(name = "trabajador")
    private int trabajador;

    /*  FK  */
    @Column(name = "zona_sitec_id")
    private int zonaSitecId;

    /*  FK  */
    @Column(name = "user_id")
    private int userId;

    @Column(name = "administrador_empresa")
    private int administradorEmpresa;

    @Column(name = "alias")
    private String alias;
}

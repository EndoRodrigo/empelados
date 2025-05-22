package com.endorodrigo.empleados.service;

import com.endorodrigo.empleados.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> findAll();
    public Empleado findById(int id);
    public Empleado save(Empleado empleado);
}

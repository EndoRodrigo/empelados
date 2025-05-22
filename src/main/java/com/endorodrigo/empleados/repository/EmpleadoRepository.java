package com.endorodrigo.empleados.repository;

import com.endorodrigo.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
}

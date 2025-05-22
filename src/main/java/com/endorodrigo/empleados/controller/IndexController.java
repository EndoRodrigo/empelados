package com.endorodrigo.empleados.controller;

import com.endorodrigo.empleados.model.Empleado;
import com.endorodrigo.empleados.repository.EmpleadoRepository;
import com.endorodrigo.empleados.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String run(ModelMap model) {
        List<Empleado> empleados = empleadoService.findAll();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        model.addAttribute("employed", empleados);
        return "index";
    }
}

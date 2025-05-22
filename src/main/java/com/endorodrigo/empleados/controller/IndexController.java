package com.endorodrigo.empleados.controller;

import com.endorodrigo.empleados.model.Empleado;
import com.endorodrigo.empleados.repository.EmpleadoRepository;
import com.endorodrigo.empleados.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "index"; //index.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; //agregar.jsp
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditar(@ModelAttribute("empleadoForma")  Empleado empleadoForma, ModelMap model) {
        logger.info(empleadoForma.toString());
        Empleado empleado = empleadoService.findById(empleadoForma.getId());
        model.put("empleado", empleado);
        return "editar"; //editar.jsp
    }

    //empleadoForma contiene la informacion del formulario
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma")  Empleado empleadoForma) {
        logger.info(empleadoForma.toString());
        empleadoService.save(empleadoForma);
        return "redirect:/";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma")  Empleado empleadoForma) {
        logger.info("new employed "+ empleadoForma.toString());
        empleadoService.save(empleadoForma);
        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int id) {
        logger.info("eliminar "+ id);
        Empleado empleado = empleadoService.findById(id);
        logger.info("delate employed "+ empleado);
        empleadoService.delete(id);
        return "redirect:/";
    }
}

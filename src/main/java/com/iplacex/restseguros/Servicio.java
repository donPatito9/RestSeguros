/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iplacex.restseguros;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author UserDevs
 */
@Path("/proceso")
public class Servicio {
    private static List<Proceso> listadoProcesos = new ArrayList<Proceso>();
    
    static {
            listadoProcesos.add(new Proceso(1,"solicitar seguro",new Date(),new Date()));
            listadoProcesos.add(new Proceso(2,"gestionar solicitud",new Date(),new Date()));
            listadoProcesos.add(new Proceso(3,"enviar propuesta",new Date(),new Date()));
            listadoProcesos.add(new Proceso(4,"recibir solicitud",new Date(),new Date()));
            listadoProcesos.add(new Proceso(5,"aprobar solicitud",new Date(),new Date()));
            
    }
 
 //Consultar Entity  
@GET
@Path("/consultarProcesos")
public String findAllProcesos() {
   String salida;
   Gson gson = new GsonBuilder().create();
   Respuesta r = new Respuesta();
   r.setStatus(200);
   r.setData(listadoProcesos);
   salida = gson.toJson(r);
   return salida;
}

//Agregar Entity

@POST
@Path("/agregarPocesos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Respuesta addProcesos(Proceso proceso) {
    Gson gson = new GsonBuilder().create();
    
    listadoProcesos.add(proceso);
    
    Respuesta r = new Respuesta();
    r.setStatus(200);
    r.setData(gson.toJson(proceso));
    return r;
}

//Modificar Entity

@PUT
@Path("/modificarProceso")
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
public String updateProceso(Proceso proceso) {
    String salida;
    int i=0;
    Gson gson = new GsonBuilder().create();
    Respuesta r = new Respuesta();
    
    for(Proceso aux : listadoProcesos) {
        if(aux.getNombre().equals(proceso.getNombre())){
          listadoProcesos.get(i).setInicio(proceso.getInicio());
          listadoProcesos.get(i).setTermino(proceso.getTermino());
        }
        i++;
    }
    r.setStatus(200);
    r.setData("Proceso modificado nombre:" + proceso.getNombre());
    salida = gson.toJson(r);
    return salida;
}

//Eliminar Entity
 @DELETE
 @Path("/eliminarProceso/{nombre}")
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
public String deleteProceso(@PathParam("nombre")String nombre) {
   
    int i=0,posicion= -1;
    String salida;
    Gson gson = new GsonBuilder().create();
    Respuesta r = new Respuesta();
    
    for(Proceso aux : listadoProcesos) {
        if(aux.getNombre().equals(nombre)){
            posicion = i;
        }
        i++;
}
    listadoProcesos.remove(posicion);
    
    r.setStatus(200);
    r.setData("Proceso eliminado :" + nombre);
    salida = gson.toJson(r);
    return salida;
}
}


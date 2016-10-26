/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import edu.eci.pdsw.samples.services.ServiciosForoStub;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 *  Clases de equivalencia:
 * 
 * Clase 1: La entrada foro tiene asociado un usuario 
 *      la prueba es valida
 * 
 * calse 2: La entrada foro no tiene asociado un usuario 
 *      la prueba no es valida
 */
public class EntradasForoTest {
    
    public EntradasForoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void EntradaForoConUsuario(){
        ServiciosForo sf = ServiciosForo.getInstance();
        Usuario us = new Usuario("martin@gmail.com","martin");
        Date dt = new Date(java.util.Calendar.getInstance().getTime().getTime());
        EntradaForo ef = new EntradaForo(1,us,"Comentario de prueba","Esto es el titulo de una prueba",dt);
        try{
            sf.registrarNuevaEntradaForo(ef);
        }
        catch (Exception e){
            System.out.println("lol");
            e.printStackTrace();
            fail("Ha retornado error con usuario creado");
        }
    }
    
    @Test
    public void EntradaForoSinUsuario(){
        ServiciosForo sf = ServiciosForo.getInstance();
        EntradaForo ef = new EntradaForo();
        try{
            sf.registrarNuevaEntradaForo(ef);
            fail("No Ha retornado error sin usuario creado");
        } catch (Exception e){
        }
    }   
    
    @Test
    public void idInvalido(){
        ServiciosForo sf = ServiciosForo.getInstance();
        try {
            sf.consultarEntradaForo(-50);
            fail("Ha consultado un foro con id invalida");
        } catch (ExcepcionServiciosForos e) {
            
        }
        
    }
}

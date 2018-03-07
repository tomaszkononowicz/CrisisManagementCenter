/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kononowicz.cmc.resources;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Tomasz
 */
@Path("/geo")
public class GeoResource {
    
    private static final String GOOGLE_KEY = "AIzaSyAHiRF8JG-d57pGP4BRz7KeESbmNupWVL4";
    private static final GeoApiContext geoApiContext = new GeoApiContext().setApiKey(GOOGLE_KEY);
           
    
    @GET
    @Path("distance")
    @Produces(MediaType.APPLICATION_JSON)
    public DistanceMatrix getDistance(
            @QueryParam("source") String source,
            @QueryParam("destination") String destination) throws ApiException, InterruptedException, IOException {

            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);
            DistanceMatrix matrix = request.origins(source)
                    .destinations(destination)
                    .language("pl-PL")
                    .await();
            
            return matrix;
    }
}

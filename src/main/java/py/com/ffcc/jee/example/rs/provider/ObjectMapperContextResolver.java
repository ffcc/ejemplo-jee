package py.com.ffcc.jee.example.rs.provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperContextResolver implements
        ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        ObjectMapper objectMapper = new ObjectMapper();
        /* Configuraciones */
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        /* Serializer */
        SimpleModule customModule = new SimpleModule("CustomModule",
                new Version(1, 0, 0, null, "example", "jee"));
        objectMapper.registerModule(customModule);
        return objectMapper;
    }
}

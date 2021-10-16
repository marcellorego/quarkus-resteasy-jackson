package br.com.fourmart;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import io.quarkus.runtime.Application;

@OpenAPIDefinition(
    tags = {
            @Tag(name="widget", description="Widget operations."),
            @Tag(name="gasket", description="Operations related to gaskets")
    },
    info = @Info(
        title="Quarkus Sample API",
        version = "1.0.0-SNAPSHOT",
        contact = @Contact(
            name = "Sample API Support",
            url = "http://4mart.com.br/fale-conosco/",
            email = "contato@4mart.com.br"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)

public class SampleAppliaction extends Application {

    protected SampleAppliaction(boolean auxilaryApplication) {
        super(auxilaryApplication);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void doStart(String[] args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void doStop() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    
}

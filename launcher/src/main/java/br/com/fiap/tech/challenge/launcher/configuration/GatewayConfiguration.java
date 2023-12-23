package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.gateway.product.ProductGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.ProductReaderRepository;
import br.com.fiap.tech.challenge.adapter.repository.ProductWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.ProductReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.ProductWriterGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public ProductReaderGateway productReaderGateway(ProductReaderRepository repository) {
        return ProductGatewayFactory.productReaderGateway(repository);
    }

    @Bean
    public ProductWriterGateway productWriterGateway(ProductWriterRepository repository) {
        return ProductGatewayFactory.productWriterGateway(repository);
    }
}

package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.rest.common.handler.error.ApiErrorResponse;
import br.com.fiap.tech.challenge.rest.resource.request.CreateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Produto", description = "API responsável pelo gerenciamento de Produto")
public interface CreateProductResourceDoc {

    @Operation(
            summary = "Cadastra um novo produto",
            description = "Cadastra um novo produto no banco de dados.",
            responses = {
                @ApiResponse(responseCode = "201", description = "Retorno em caso de sucesso se um produto foi cadastrado", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") }),
                @ApiResponse(responseCode = "400", description = "Retorno informando qual campo do produto está incorreto e por qual motivo", content = { @Content(schema = @Schema(implementation = ApiErrorResponse.class), mediaType = "application/json") })
            }
    )
    ProductResponse create(CreateProductRequest request);
}

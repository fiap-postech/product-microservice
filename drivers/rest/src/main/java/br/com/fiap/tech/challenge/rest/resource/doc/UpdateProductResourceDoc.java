package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.rest.common.handler.error.ApiErrorResponse;
import br.com.fiap.tech.challenge.rest.resource.request.UpdateProductRequest;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produto", description = "API responsável pelo gerenciamento de Produto")
public interface UpdateProductResourceDoc {

    @Operation(
            summary = "Atualiza um produto",
            description = "Atualiza os dados do produto no banco de dados",
            responses = {
                @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso em que o produto foi atualizado", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") }),
                @ApiResponse(responseCode = "400", description = "Retorno informando qual campo do produto está incorreto e por qual motivo", content = { @Content(schema = @Schema(implementation = ApiErrorResponse.class), mediaType = "application/json") })
            }
    )
    ProductResponse update(UpdateProductRequest request);
}

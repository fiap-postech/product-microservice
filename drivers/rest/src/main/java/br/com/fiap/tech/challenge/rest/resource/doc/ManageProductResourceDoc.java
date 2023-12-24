package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produto", description = "API responsável pelo gerenciamento de Produto")
public interface ManageProductResourceDoc {

    @Operation(
            summary = "Habilita um produto",
            description = "Habilita um produto com status desabilitado no banco de dados.",
            responses = {
                @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso em que produto foi habilitado", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") })
            }
    )
    ProductResponse enable(@Parameter(description = "UUID do produto a ser habilitado", required = true) String uuid);

    @Operation(
            summary = "Desabilita um produto",
            description = "Desabilita um produto com status habilitado no banco de dados.",
            responses = {
                @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso se um produto foi desabilitado", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") })
            }
    )
    ProductResponse disable(@Parameter(description = "UUID do produto a ser desabilitado", required = true) String uuid);
}

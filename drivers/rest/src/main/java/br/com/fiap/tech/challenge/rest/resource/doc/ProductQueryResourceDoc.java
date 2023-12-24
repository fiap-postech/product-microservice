package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;

@Tag(name = "Produto", description = "API responsável pelo gerenciamento de Produto")
public interface ProductQueryResourceDoc {

    @Operation(
        summary = "Retorna todos os produtos",
        description = "Busca todos os produtos cadastrados no banco de dados de acordo com a requisição",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso todos os produtos de acordo com a requisição", useReturnTypeSchema = true)
    })
    ResponseList<ProductResponse> getAllAvailable(Pageable pageable,
                                                  @Parameter(description = "Filtra pela categoria do produto", required = true) ProductCategory category);
    @Operation(
            summary = "Retorna um produto pelo UUID",
            description = "Busca o produto registrado no banco de dados daquele UUID",
            responses = {
                @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso um produto de acordo com a requisição", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") }),
                @ApiResponse(responseCode = "400", description = "O UUID de produto fornecido não foi encontrado", content = { @Content(schema = @Schema()) })
            }
    )
    ProductResponse getByUUID(@Parameter(description = "UUID de produto a ser pesquisado", required = true) String uuid);
}

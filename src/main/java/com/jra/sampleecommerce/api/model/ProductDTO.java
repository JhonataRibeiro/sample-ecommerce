package com.jra.sampleecommerce.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Schema(name = "ProductDTO", description = "Product information")
public class ProductDTO extends RepresentationModel<ProductDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("tag")
    @Valid
    private List<Tag> tag = null;

    public ProductDTO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Product identifier
     *
     * @return id
     */

    @Schema(name = "id", description = "Product identifier", required = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Product Name
     *
     * @return name
     */

    @Schema(name = "name", description = "Product Name", required = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDTO description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Prodcut's description
     *
     * @return description
     */

    @Schema(name = "description", description = "Prodcut's description", required = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDTO imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    /**
     * Product image's URL
     *
     * @return imageUrl
     */

    @Schema(name = "imageUrl", description = "Product image's URL", required = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductDTO price(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     */
    @Valid
    @Schema(name = "price", required = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductDTO count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Product count
     *
     * @return count
     */

    @Schema(name = "count", description = "Product count", required = false)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ProductDTO tag(List<Tag> tag) {
        this.tag = tag;
        return this;
    }

    public ProductDTO addTagItem(Tag tagItem) {
        if (this.tag == null) {
            this.tag = new ArrayList<>();
        }
        this.tag.add(tagItem);
        return this;
    }

    /**
     * Tags associated with the product
     *
     * @return tag
     */
    @Valid
    @Schema(name = "tag", description = "Tags associated with the product", required = false)
    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductDTO productDTO = (ProductDTO) o;
        return Objects.equals(this.id, productDTO.id) &&
                Objects.equals(this.name, productDTO.name) &&
                Objects.equals(this.description, productDTO.description) &&
                Objects.equals(this.imageUrl, productDTO.imageUrl) &&
                Objects.equals(this.price, productDTO.price) &&
                Objects.equals(this.count, productDTO.count) &&
                Objects.equals(this.tag, productDTO.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageUrl, price, count, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


#version 150

#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:fog.glsl>

in float cylindricalVertexDistance;
in float sphericalVertexDistance;
in vec4 vertexColor;

out vec4 fragColor;

void main() {
	fragColor = (1.0F - total_fog_value(sphericalVertexDistance, cylindricalVertexDistance, FogEnvironmentalStart, FogEnvironmentalEnd, FogRenderDistanceStart, FogRenderDistanceEnd)) * vertexColor * ColorModulator;
}

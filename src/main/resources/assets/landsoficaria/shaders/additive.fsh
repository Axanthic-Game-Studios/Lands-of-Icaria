#version 150

#moj_import <minecraft:fog.glsl>

uniform float FogStart;
uniform float FogEnd;
uniform vec4 ColorModulator;

in float vertexDistance;
in vec4 vertexColor;

out vec4 fragColor;

void main() {
	fragColor = vertexColor * linear_fog_fade(vertexDistance, FogStart, FogEnd) * ColorModulator;
}

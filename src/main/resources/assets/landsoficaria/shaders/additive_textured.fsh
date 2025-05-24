#version 150

#moj_import <minecraft:fog.glsl>

uniform float FogStart;
uniform float FogEnd;
uniform sampler2D Sampler0;
uniform vec4 ColorModulator;

in float vertexDistance;
in vec2 texCoord0;
in vec4 vertexColor;

out vec4 fragColor;

void main() {
	fragColor = vertexColor * texture(Sampler0, texCoord0) * linear_fog_fade(vertexDistance, FogStart, FogEnd) * ColorModulator;
}

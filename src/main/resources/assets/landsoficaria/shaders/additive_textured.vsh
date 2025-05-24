#version 150

#moj_import <minecraft:fog.glsl>

in vec2 UV0;
in vec3 Position;
in vec4 Color;

uniform int FogShape;
uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out float vertexDistance;
out vec2 texCoord0;
out vec4 vertexColor;

void main() {
	gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
	texCoord0 = UV0;
	vertexColor = Color;
	vertexDistance = fog_distance(Position, FogShape);
}

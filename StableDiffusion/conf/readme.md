# From the doc (manual extract)

## Prompt Format

Start by asking a list of questions
1. Do you want a photo or a painting?
2. What’s the subject of the photo? Person? An animal or perhaps a landscape?
3. What details do you want to add?
○ Special Lighting. Soft, ambient, ring light, neon
○ Environment. Indoor, outdoor, underwater, in space
○ Color Scheme. Vibrant, dark, pastel
○ Point of view. Front, Overhead, Side
○ Background. Solid color, nebula, forest
4. In a specific art style? 3D render, studio ghibli, movie poster
5. A specific photo type? Macro, telephoto


example :

```
A painting of a cute goldendoodle
wearing a suit, natural light, in the sky,
with bright colors, by Studio Ghibli
```

### Rules 

* You can change the order of the words a little bit if one part is important. The earlier a word is in the sentence, the more importance it will be given
* The order and presentation of our desired output is almost as an important aspect as the vocabulary itself. It is recommended to list your concepts explicitly and separately than trying to cramp it into one simple sentence. 
* Resolution – default is 512x512
* Classifier Free Guidance (CFG) – default is 7 : should stay between 4 and 15 proportional to prompt complexity.

CFG 2 - 6: Creative, but might not follow the prompt
CFG 7 - 10: Recommended for most prompts. Good
balance between creativity and guided generation
CFG 10 - 15: When you’re sure that your prompt is
good/specific enough.
CFG 16 - 20: Not generally recommended unless the
prompt is well detailed. Might affect coherence and
quality

* Step count – default is 50

Stable Diffusion creates an image by starting with a canvas full of noise and denoise it gradually to reach the
final output, this parameter controls the number of these denoising steps. Usually, higher is better but to a
certain degree, for beginners it’s recommended to stick with the default.

* Token efficiency

Your prompt is limited effectively to 75 tokens. If you are working with a long prompt try to be efficient with
words that do not significantly add to your meaning. A typical example is when using an artist as a modifier
to get a particular style. Here are a few prompts and their token counts. They all will produce a piece that
looks like it was created by Vincent Van Gogh with their associated token count

* You got a great generation with a messed-up facial features? Use GFP-GAN to fix it (use it [online](https://app.baseten.co/apps/QPp4nPE/operator_views/RqgOnqV)

* Negative prompt

You can use the negative prompt to tell Stable Diffusion what not to include in the image. This is especially useful when paired with using the same seed for the new generation

### Magic words

Quality words  can make a dramatic difference.

* HDR, UHD, 64K

A landscape, HDR, UHD, 64K

* Highly detailed

Joann of Arc portrayed
by Jennifer Lawrence,
highly detailed, concept

* Studio lighting

A cinematic film still of
Morgan Freeman
starring as 50 Cent,
portrait, 40mm lens,
shallow depth of field,
close up, studio lighting

* Professional

* Trending on artstation

Portrait photo of a
beautiful female cyborg
from 1920, trending on
artstation

* Unreal engine

Hyper realistic 4 d
model, unreal engine

* Vivid Colors

* Bokeh

* High resolution scan

Photo of a parade in
New York City, High
resolution scan

* Sketch vs Painting

> Almost always, sketch creates pencil images, while painting adds colors and will probably give an older looking scene

## Photography 

### Photography Styles

* Polaroid

still photo of a child
sitting in the middle of a
wide empty city street,
his back to the camera,
symmetrical, polaroid
photography, highly
detailed, crisp quality

* Tilt-Shift

photo of construction
site, workers, tilt shift
effect, bokeh, Nikon

* Product Shot

Product shot of nike
shoes, with soft vibrant
colors, 3d blender
render, modular
constructivism, blue
background, physically
based rendering,
centered

* Long Exposure

An aerial view of a city at
night, long exposure,
instagram contest

* Portrait

Portrait photo of a
storm trooper with his
beautiful wife on his
wedding day

* Color-Splash

Color splash wide photo
of red phone booth in
the middle of empty
street, detailed, mist, soft
vignette

* Monochrome

Photo of staircase in
abandoned building,
symmetrical,
monochrome
photography, highly
detailed, crisp quality
and light reflections,
100mm lens

* Satellite

Google earth satellite
image, of New York City,
detailed buildings and
streets

### Cameras

* Gopro


Monkey swimming,
Gopro footage

* CCTV

Darth Vader at a
convenience store,
pushing shopping cart,
CCTV still, high-angle
security camera feed

* Drone

Drone photo of Tokyo,
city center

* Thermal

Thermal camera footage
from a helicoper, war
scene

### Lenses

* Telephoto
Alligator emerging from
water, telephoto lens

* Fish-eye
Night club, people
dancing, Fish-eye lens
* 800mm
Photo of hummingbird,
800mm lens
* Macro
Photo of a ladybug-bee
hybrid standing on a
tulip, macro lens

### Lighting

* Nostalgic

Fallout concept art school interior
render grim, nostalgic lighting,
unreal engine 5

* Purple Neon

Fallout concept art school interior
render grim, realistic purple neon
lighting unreal engine 5

* Sun Rays

Fallout concept art school interior
render grim, sun rays coming
through window, unreal engine 5

## Art Mediums

example : 

    Tiny cute goat painter toy, standing character, soft smooth lighting, soft pastel colors, skottie young, 3d blender render, polycount, modular constructivism, pop surrealism, physically based rendering, square image

* Chalk
* Graffiti
* Water Colors
* Oil Painting
* Fabric (crochet)
* Pencil Drawing
* Wood
* Clay

## Styles 

* Portrait

Derek Gores, Miles Aldridge, Jean Baptiste-Carpeaux,
Anne-Louis Girodet

* Landscape

Alejandro Bursido, Jacques-Laurent Agasse, Andreas
Achenbach, Cuno Amiet

* Horror

H.R.Giger, Tim Burton, Andy Fairhurst, Zdzislaw Beksinski

* Anime

Makoto Shinkai, Katsuhiro Otomo, Masashi Kishimoto,
Kentaro Miura

* Sci-fi

Chesley Bonestell, Karel Thole, Jim Burns, Enki Bilal

* Photography

Ansel Adams, Ray Earnes, Peter Kemp, Ruth Bernhard

* Concept artists (video game)

Emerson Tung, Shaddy Safadi, Kentaro Miura

## Illustration

* Isometric assets
* Low Poly
* Pixar Renders
* 3D Item Render
* Children’s book
* Vector
* Scientific Illustration
* Comic
* Caricature
* Propaganda Poster
* Movie Poster
* Psychedelic Art
* Splash Art
* Ukiyo-e
* Stickers
* Fantasy Maps

## Positive emotions

* Cosy
* Romantic
* Joyful

joyful photo of a husky puppy splashing water at the beach, canon eos r3

* Energetic
* Hope
* Lust
* Peaceful 

A peaceful Japanese city street, dreamy, soft colors, studio ghibli style

* Satisfaction

## Negative emotions 

* Depressing
* Grim
* Suffering

Digital painting showing
the suffering of a
woman, sitting on a
bench in the forest, by
goro fujita

## Aesthetics

### Vibrant

* Weirdcore

Weirdcore image of a
zoo

* Acidwave

Dog in the park,
Acidwave aesthetic

* Dreamcore

Photo of neighborhood,
Dreamcore style

* Vaporwave

Vaporwave pool

### Glooy
* Liminal Space

Flooded, liminal space,
underground city
carpark, lighting with
lensflares, photorealistic
8 k, eerie

* After Hours

After hours, stairs to the
park

* Brutalism

Building, brutalism
architecture

* Post-Apocalyptic

Photo in a
Post-Apocalyptic town,
with houses and cars

### Historic

* Baroque

Painting of Danny
DeVito, in Baroque cloth
and style

* Sovietwave

People walking in the
street, Sovietwave

* Wild West

Photo of a car driving in
a town, Wild West

* Film Noir

Chandler and monica,
detailed faces, Film Noir
style


# Prompts reference examples 


Full length oil painting of gorgeous woman as a
translucent arctic fox spirit| detailed face| wearing
white dress| straight white hair| mythical| elegant|
hyperrealism| highly detailed| intricate detailed|
volumetric lighting| Ukiyo-E| by Anne Stokes and
Noriyoshi Ohrai


Very detailed female, steampunk city taken over by
plants in the background, d & d, fantasy, with blue
flowers, beautiful face, hyperrealism delicate detailed
complex, sophisticated, vibrant colors, volumetric
lighting, pop surrealism art by Mark Ryden and Anna
Dittman


An oil painting of the autumnal equinox,a woman
surrounded by autumn leaves, an airbrush painting
by Josephine Wall, deviantart, psychedelic art,
airbrush art, detailed painting, pre-raphaelite, 3d
render, rococo art


detailed miniature diorama a soviet residential
building, brutalism architecture, car parking nearby,
elderly man passing by, sunny day, warm and joyful
atmosphere, summer, streetlamps, several birches
nearby


An elegant winged fairy in the lord of the rings
scenery landscape, looking out at a vast lush valley
ﬂowers and homes made of mushrooms, stream,
sunrise, god's rays highly detailed, vivid color,
cinematic lighting, perfect composition, 8 k, gustave
dore, derek zabrocki, greg rutkowski, belsinski, octane
render.


Oil painting of a fantasy treehouse by ivan shishkin
and aivazovsky, highly detailed, masterpiece


Landscape photography of fundatura ponorului by
marc adamus, morning, mist, rays of light, beautiful


A beautiful landscape at dawn by atey ghailan, ismail
inceoglu, michal lisowski, artstation, volumetric light,
high detail, perfect



Kodak portra 4 0 0, wetplate, ﬁsheye, award - winning
portrait by britt marling, 1 8 8 0 s kitchen, ghost,
picture frames, shining lamps, dust, smoke, 1 8 8 0 s
furniture, wallpaper, carpet, books, muted colours,
wood, fog, plants, ﬂowers

A monster is standing in a dimly lit hallway, terrifying
visuals, horror elements, dark ambiance.



 quality 3D render neo - cyberpunk very cute half
ﬂuffy! wombat!! half cyborg with headphones,
mechanical paw, highly detailed, unreal engine
cinematic smooth, in the style of detective pikachu,
hannah yata charlie immer, neon purple light, low
angle, uhd 8k, sharp focus


Standing breaded chicken with a crown of a king in
top of it, hyper realistic, 4k


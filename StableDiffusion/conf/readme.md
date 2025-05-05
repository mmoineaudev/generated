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

--

# 1. Magic Words + Photography 

     HDR, Telephoto, Sunset
    Example: Generate a 64K UHD image using a telephoto lens (e.g., Canon EF 70-200mm f/2.8L IS III USM) to capture a stunning sunset in Yosemite National Park.
    Artist Suggestion: Michael Kenna
    Camera Suggestion: Sony α7R IV
     UHD, Wide-angle, Underwater
    Example: Create an underwater scene captured with a wide-angle lens (e.g., Nikon AF-S NIKKOR 16-35mm f/4G ED VR) using a GoPro HERO9 Black.
    Artist Suggestion: Michael Aw
    Camera Suggestion: Olympus OM-D E-M1 Mark III with underwater housing
     Professional, Macro, Bokeh
    Example: Produce a professional macro photo (e.g., Canon MP-E 65mm f/2.8 1-5x Macro Photo) with bokeh effect using a Nikon Z7 II.
    Artist Suggestion: Thomas Shahan
    Camera Suggestion: Fujifilm X-T4
     

2. Magic Words + Art Mediums 

     Highly detailed, Oil painting, Impressionism
    Example: Create an impressionistic oil painting (e.g., Claude Monet's "Water Lilies") with highly detailed elements using studio lighting conditions.
    Artist Suggestion: Claude Monet
    Medium Suggestion: Oil paints by Winsor & Newton
     Studio lighting, Watercolors, Surrealism
    Example: Generate a surrealistic watercolor painting (e.g., Salvador Dalí's "The Persistence of Memory") under studio lighting conditions using Daniel Smith watercolors.
    Artist Suggestion: Salvador Dalí
    Medium Suggestion: Arches cold-pressed paper
     Trending on artstation, Chalk, Street art
    Example: Design a trending street art chalk piece (e.g., Shepard Fairey's "Obey") inspired by the artist's iconic style using Pastel de Paris chalk.
    Artist Suggestion: Shepard Fairey
    Medium Suggestion: Asphalt or concrete surface
     

3. Magic Words + Illustration 

     High resolution scan, Isometric assets, Steampunk
    Example: Create high-resolution isometric steampunk assets (e.g., a Victorian-era airship) with detailed scans using Blender's Cycles render engine.
    Artist Suggestion: WLOP
    Software Suggestion: Adobe Illustrator CC
     Bokeh, Children's book, Whimsical
    Example: Generate whimsical children's book illustrations (e.g., a story about talking animals) with bokeh effect using Procreate and an iPad Pro.
    Artist Suggestion: Beatrix Potter
    Software Suggestion: Procreate on iPad Pro
     Sketch vs Painting, Vector, Art Nouveau
    Example: Design an art nouveau vector sketch (e.g., Alphonse Mucha's "The Seasons") with intricate details using Adobe Illustrator CC.
    Artist Suggestion: Alphonse Mucha
    Software Suggestion: Adobe Illustrator CC
     

4. Magic Words + Emotions 

     Romantic, Vivid colors, Sunrise
    Example: Capture the romantic emotions of a vivid sunrise scene using a Sony α7R IV and processing it in Lightroom to enhance colors.
    Artist Suggestion: Alfred Stieglitz
    Camera Suggestion: Sony α7R IV
     Hopeful, Soft pastel colors, Spring
    Example: Evoke hopefulness through soft pastel colors (e.g., creating a springtime landscape) using watercolors by Daniel Smith and cold-pressed paper.
    Artist Suggestion: Georgia O'Keeffe
    Medium Suggestion: Watercolors by Daniel Smith on Arches cold-pressed paper
     Nostalgic, Sepia tone, Old photograph
    Example: Create a nostalgic old photograph with sepia tones (e.g., a vintage family portrait) using a medium format camera like the Fujifilm GFX10S and processing it in Lightroom.
    Artist Suggestion: Sally Mann
    Camera Suggestion: Fujifilm GFX10S
     

5. Magic Words + Aesthetics 

     Glowy, Luminous, Dreamcore
    Example: Generate a glowy dreamcore aesthetic (e.g., a serene forest at night) using a Sony α7R IV and processing it in Lightroom with luminosity masks.
    Artist Suggestion: WLOP
    Camera Suggestion: Sony α7R IV
     Vibrant, Weirdcore, Cyberpunk
    Example: Create a vibrant weirdcore cyberpunk aesthetic (e.g., a neon-lit cityscape) using a Canon EOS 5D Mark IV and processing it in Photoshop with vibrant color grading.
    Artist Suggestion: Simon Stålenhag
    Camera Suggestion: Canon EOS 5D Mark IV
     Historic, Monochrome, Vintage travel poster design
    Example: Design a historic monochrome vintage travel poster (e.g., the Golden Gate Bridge) using Procreate on an iPad Pro and processing it with a vintage filter.
    Artist Suggestion: Ludwig Hohlwein
    Software Suggestion: Procreate on iPad Pro
     

6. Magic Words + Photography & Art Mediums 

     Highly detailed, Oil painting, Long exposure
    Example: Create an oil painting (e.g., Rembrandt's "The Night Watch") with highly detailed elements using long exposure photography techniques and a Nikon D850.
    Artist Suggestion: Rembrandt van Rijn
    Camera Suggestion: Nikon D850
     Studio lighting, Pastel colors, Landscape
    Example: Generate a landscape scene (e.g., a serene meadow) in pastel colors under studio lighting conditions using a Sony α7R IV and processing it in Lightroom.
    Artist Suggestion: Georgia O'Keeffe
    Camera Suggestion: Sony α7R IV
     Bokeh, Watercolors, Nature
    Example: Capture the beauty of nature (e.g., a close-up of a flower) with watercolor paints and bokeh effect using an iPhone 12 Pro Max.
    Artist Suggestion: Georgia O'Keeffe
    Camera Suggestion: iPhone 12 Pro Max
     

7. Magic Words + Photography & Illustration 

     Professional, Isometric assets, Cityscape
    Example: Design a professional cityscape using isometric assets (e.g., a futuristic metropolis) and illustration techniques with Adobe Photoshop CC.
    Artist Suggestion: Simon Stålenhag
    Software Suggestion: Adobe Photoshop CC
     HDR, Digital art, Pop surrealism
    Example: Create pop surrealistic digital art (e.g., a whimsical creature) with HDR techniques using Procreate on an iPad Pro.
    Artist Suggestion: Mark Ryden
    Software Suggestion: Procreate on iPad Pro
     Trending on artstation, Vector, Street art graffiti
    Example: Design trending street art graffiti vector illustrations (e.g., a vibrant murals) using Adobe Illustrator CC.
    Artist Suggestion: Shepard Fairey
    Software Suggestion: Adobe Illustrator CC
     

8. Magic Words + Photography & Emotions 

     Romantic, Soft colors, Couple portrait
    Example: Capture the romantic emotions of a couple portrait with soft colors using a Fujifilm X-T4 and processing it in Lightroom.
    Artist Suggestion: Annie Leibovitz
    Camera Suggestion: Fujifilm X-T4
     Hopeful, Warm lighting, Sunrise over mountains
    Example: Evoke hopefulness through warm lighting and sunrise over mountains photography using a Canon EOS 5D Mark IV and processing it in Lightroom.
    Artist Suggestion: Ansel Adams
    Camera Suggestion: Canon EOS 5D Mark IV
     Nostalgic, Sepia tone, Old family photograph
    Example: Create a nostalgic old family photograph with sepia tones using an iPhone 12 Pro Max and processing it in the Snapseed app.
    Artist Suggestion: Sally Mann
    Camera Suggestion: iPhone 12 Pro Max
     

9. Magic Words + Photography & Aesthetics 

     Glowy, Luminous, Northern lights
    Example: Capture the glowy luminous aesthetic of northern lights photography using a Sony α7R IV and processing it in Lightroom with glow effects.
    Artist Suggestion: Michael Kenna
    Camera Suggestion: Sony α7R IV
     Vibrant, Weirdcore, Underwater world
    Example: Generate vibrant weirdcore underwater world scenes (e.g., a surreal seascape) using a GoPro HERO9 Black and processing it in Adobe Photoshop CC.
    Artist Suggestion: Alexey Kljatov
    Camera Suggestion: GoPro HERO9 Black
     Historic, Monochrome, Vintage travel poster design
    Example: Design a historic monochrome vintage travel poster (e.g., the Grand Canyon) using Procreate on an iPad Pro and processing it with a vintage filter.
    Artist Suggestion: Ludwing Hohlwein
    Software Suggestion: Procreate on iPad Pro
     

10. Magic Words + Art Mediums & Illustration 

     Highly detailed, Oil painting, Fantasy art character design
    Example: Create an oil painting with highly detailed fantasy art character design elements (e.g., a mythical creature) using studio lighting conditions and processing it in Photoshop.
    Artist Suggestion: Frank Frazetta
    Software Suggestion: Adobe Photoshop CC
     Studio lighting, Digital art, Pop surrealism character design
    Example: Generate pop surrealistic digital art character design (e.g., a whimsical creature) under studio lighting conditions using Procreate on an iPad Pro.
    Artist Suggestion: Mark Ryden
    Software Suggestion: Procreate on iPad Pro
     Bokeh, Isometric assets, Steampunk robot design
    Example: Design steampunk robot isometric assets (e.g., a Victorian-era automaton) with bokeh effect using Blender's Cycles render engine.
    Artist Suggestion: WLOP
    Software Suggestion: Blender
     

11. Magic Words + Art Mediums & Emotions 

     Romantic, Pastel colors, Love letter calligraphy
    Example: Evoke romantic emotions through pastel colored love letter calligraphy art using a dip pen and ink on acid-free paper.
    Artist Suggestion: Jessica Hische
    Medium Suggestion: Dip pen and ink on acid-free paper
     Hopeful, Bright colors, Children's book illustrations
    Example: Create hopeful children's book illustrations (e.g., a story about friendship) with bright colors using watercolors by Daniel Smith and cold-pressed paper.
    Artist Suggestion: Beatrix Potter
    Medium Suggestion: Watercolors by Daniel Smith on Arches cold-pressed paper
     Nostalgic, Sepia tone, Old photograph colorization
    Example: Colorize old photographs (e.g., a vintage portrait) using sepia tones with digital painting techniques in Photoshop.
    Artist Suggestion: Carlene Earth
    Software Suggestion: Adobe Photoshop CC
     

12. Magic Words + Art Mediums & Aesthetics 

     Glowy, Luminous, Ethereal fantasy creature
    Example: Create an ethereal fantasy creature (e.g., a mythical unicorn) with glowy luminous elements using digital painting techniques in Photoshop.
    Artist Suggestion: Wendy Froud
    Software Suggestion: Adobe Photoshop CC
     Vibrant, Acidwave, Psychedelic art pattern design
    Example: Generate vibrant acidwave psychedelic art pattern designs (e.g., a geometric mandala) with neon colors and abstract patterns using Procreate on an iPad Pro.
    Artist Suggestion: Alex Grey
    Software Suggestion: Procreate on iPad Pro
     Historic, Baroque, Religious art icon design
    Example: Design historic religious art icons (e.g., a saint's portrait) in the baroque aesthetic of that era using oil paints by Winsor & Newton.
    Artist Suggestion: Caravaggio
    Medium Suggestion: Oil paints by Winsor & Newton
     

13. Magic Words + Photography & Art Mediums 

     Highly detailed, Oil painting, Nature photography
    Example: Create an oil painting (e.g., a close-up of a flower) with highly detailed nature photography elements using studio lighting conditions and processing it in Photoshop.
    Artist Suggestion: Georgia O'Keeffe
    Software Suggestion: Adobe Photoshop CC
     Studio lighting, Watercolors, Food photography
    Example: Generate watercolor food photography scenes (e.g., a still life of fruits) under studio lighting conditions using Daniel Smith watercolors and cold-pressed paper.
    Artist Suggestion: Caravaggio
    Medium Suggestion: Watercolors by Daniel Smith on Arches cold-pressed paper
     Bokeh, Chalk, Street art typography
    Example: Design street art typography (e.g., a vibrant mural) using chalk and bokeh effect with an iPhone 12 Pro Max.
    Artist Suggestion: Shepard Fairey
    Camera Suggestion: iPhone 12 Pro Max
     

14. Magic Words + Photography & Illustration 

     Professional, Isometric assets, Architectural photography
    Example: Create professional architectural photography using isometric assets (e.g., a futuristic skyscraper) with Adobe Photoshop CC.
    Artist Suggestion: Julius Shulman
    Software Suggestion: Adobe Photoshop CC
     HDR, Digital art, Pop surrealism
    Example: Generate pop surrealistic digital art (e.g., a whimsical creature) with HDR techniques using Procreate on an iPad Pro.
    Artist Suggestion: Mark Ryden
    Software Suggestion: Procreate on iPad Pro
     Trending on artstation, Vector, Street art graffiti
    Example: Design trending street art graffiti vector illustrations (e.g., a vibrant murals) using Adobe Illustrator CC.
    Artist Suggestion: Shepard Fairey
    Software Suggestion: Adobe Illustrator CC
     

15. Magic Words + Photography & Emotions 

     Romantic, Soft colors, Couple portrait
    Example: Capture the romantic emotions of a couple portrait with soft colors using a Fujifilm X-T4 and processing it in Lightroom.
    Artist Suggestion: Annie Leibovitz
    Camera Suggestion: Fujifilm X-T4
     Hopeful, Warm lighting, Sunrise over mountains
    Example: Evoke hopefulness through warm lighting and sunrise over mountains photography using a Canon EOS 5D Mark IV and processing it in Lightroom.
    Artist Suggestion: Ansel Adams
    Camera Suggestion: Canon EOS 5D Mark IV
     Nostalgic, Sepia tone, Old family photograph
    Example: Create a nostalgic old family photograph with sepia tones using an iPhone 12 Pro Max and processing it in the Snapseed app.
    Artist Suggestion: Sally Mann
    Camera Suggestion: iPhone 12 Pro Max
     

Popular Cameras: 

     Full-frame mirrorless: Sony α7R IV, Fujifilm GFX10S, Canon EOS 5D Mark IV
     Crop sensor mirrorless: Fujifilm X-T4, Nikon Z7 II
     Compact: Sony Cyber-shot DSC-RX100 VII, Panasonic Lumix DC-FZ1000 II
     Smartphone: iPhone 12 Pro Max, Samsung Galaxy S21 Ultra
     

Artists: 

     Photography: Alfred Stieglitz, Ansel Adams, Michael Kenna, Sally Mann, Annie Leibovitz
     Painting (Oil): Rembrandt van Rijn, Claude Monet, Georgia O'Keeffe, Frank Frazetta, Caravaggio
     Digital Art & Illustration: Mark Ryden, Alex Grey, Simon Stålenhag, WLOP, Jessica Hische, Beatrix Potter
     Street Art: Shepard Fairey
     
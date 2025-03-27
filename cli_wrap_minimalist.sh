#!/bin/bash

read -rp "ça commence là" PROMPT

llama-cli \
--model ${model_name} \
    --threads 32 \
    --ctx-size 32768 \
    --seed 1234 \
    --temp 0.6 \
    --min-p 0.0 \
    --top-k 40 \
    --top-p 0.95 \
    -no-cnv \
    --samplers "top_k;top_p;min_p;temperature;" \
    --prompt "<|im_start|>user\n${PROMPT}"<|im_end|>\n<|im_start|>assistant\n<think>\n"

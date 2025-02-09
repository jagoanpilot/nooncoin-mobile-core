//
//  BBREthereumBlock.c
//  noocoinwallet-core Ethereum
//
//  Created by Ed Gamble on 3/23/2018.
//  Copyright (c) 2018 noocoinwallet LLC
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files (the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in
//  all copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//  THE SOFTWARE.

#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "BREthereumBlock.h"
#include "BREthereumPrivate.h"

struct BREthereumBlockRecord {
    char *hash;
    uint64_t number;
    uint64_t confirmations;
    uint64_t timestamp;
};

extern BREthereumBlock
createBlock (BREthereumHash hash,
             uint64_t number,
             uint64_t confirmations,
             uint64_t timestamp) {
    BREthereumBlock block = (BREthereumBlock) malloc (sizeof (struct BREthereumBlockRecord));
    block->hash = hashCopy(hash);
    block->number = number;
    block->confirmations = confirmations;
    block->timestamp = timestamp;
    return block;
}

extern BREthereumHash
blockGetHash (BREthereumBlock block) {
    return hashCopy(block->hash);
}

extern uint64_t
blockGetNumber (BREthereumBlock block) {
    return block->number;
}

extern uint64_t
blockGetConfirmations (BREthereumBlock block) {
    return block->confirmations;
}

extern uint64_t
blockGetTimestamp (BREthereumBlock block) {
    return block->timestamp;
}

private_extern void
blockFree (BREthereumBlock block) {
    free (block->hash);
    free (block);
}

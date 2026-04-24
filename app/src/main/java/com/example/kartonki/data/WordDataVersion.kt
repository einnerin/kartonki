package com.example.kartonki.data

/**
 * Version of the word/set dataset shipped with the app.
 *
 * HOW TO ADD OR CHANGE WORD DATA:
 * 1. Edit the relevant WordData*.kt file.
 * 2. Bump [CURRENT] by 1.
 * 3. Build and deploy.
 *
 * WordLoader will detect the version change on the next launch and run a full
 * upsert of all sets and words — no SQL migrations, no sentinel checks needed.
 */
object WordDataVersion {
    const val CURRENT = 766
}
